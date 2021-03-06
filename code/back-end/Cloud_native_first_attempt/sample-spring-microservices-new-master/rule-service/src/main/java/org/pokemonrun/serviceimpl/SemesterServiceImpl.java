package org.pokemonrun.serviceimpl;

import org.pokemonrun.dao.BasicRuleDao;
import org.pokemonrun.dao.CampusRecordDao;
import org.pokemonrun.dao.SemesterDao;
import org.pokemonrun.entity.BasicRule;
import org.pokemonrun.entity.Semester;
import org.pokemonrun.info.SemesterDetailedInfo;
import org.pokemonrun.info.SemesterInfo;
import org.pokemonrun.service.SemesterService;
import org.pokemonrun.util.SemesterConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterServiceImpl implements SemesterService {
    @Autowired
    private SemesterDao semesterDao;
    @Autowired
    private CampusRecordDao campusRecordDao;
    @Autowired
    private BasicRuleDao basicRuleDao;

    private Semester testSemester(SemesterInfo info){
        Semester semester = SemesterConverter.toEntity(info);
        // negative mileage goal
        if(semester.getMileageGoal() < 0){
            return null;
        }
        // Invalid: past time as end time
        long end = semester.getEndTime();
        long now = System.currentTimeMillis();
        if(now >= end){
            return null;
        }
        return semester;
    }

    @Override
    public boolean beginNewSemester(SemesterInfo info) {
        Semester semester = testSemester(info);
        if(semester == null){
            return false;
        }
        // execute
        if(!campusRecordDao.reset()){
            return false;
        }
        semester.setStartTime(System.currentTimeMillis());
        return semesterDao.setSemester(semester);
    }

    @Override
    public boolean modifySemester(SemesterInfo info) {
        // non-existing semesters should not be modified
        Semester semester = semesterDao.getSemester();
        if(semester == null){
            return false;
        }
        // check if intended semester info is valid
        Semester semester1 = testSemester(info);
        if(semester1 == null){
            return false;
        }
        // execute
        semester1.setStartTime(semester.getStartTime());
        return semesterDao.setSemester(semester1);
    }

    @Override
    public String getMileageGoal() {
        Semester semester = semesterDao.getSemester();
        if(semester == null){
            return "0";
        }
        return String.valueOf(semester.getMileageGoal());
    }

    @Override
    public SemesterDetailedInfo getSemesterDetails() {
        Semester semester = semesterDao.getSemester();
        BasicRule rule = basicRuleDao.getBasicRule();
        if(semester == null || rule == null){
            return null;
        }
        return SemesterConverter.toDetails(semester, rule);
    }
}
