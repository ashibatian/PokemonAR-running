package example.com.pkmnavidemo4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import example.com.pkmnavidemo4.classes.ElfSourceController;
import example.com.pkmnavidemo4.classes.FightTextAdapter;
import example.com.pkmnavidemo4.classes.TestRecycleViewAdapter;
import example.com.pkmnavidemo4.classes.UserData;

public class FightActivity extends AppCompatActivity {
    private int i;
    private int leftHp=100;
    private int rightHp=100;
    private int leftElf;
    private int rightElf;
    private int leftPower;
    private int rightPower;
    private int leftGrade;
    private int rightGrade;
    private ImageView image1;
    private ImageView image2;
    private List<String> list;
    private Button start;
    private Button finish;
    RecyclerView mRecyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        leftElf = intent.getIntExtra("leftElf", 1);
        rightElf = intent.getIntExtra("rightElf", 2);
        leftPower = intent.getIntExtra("leftPower", 120);
        rightPower = intent.getIntExtra("rightPower", 100);
        leftGrade = intent.getIntExtra("leftGrade",2);
        rightGrade = intent.getIntExtra("rightGrade", 2);
        setContentView(R.layout.activity_fight);
        mRecyclerView = findViewById(R.id.elf_fight_recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(FightActivity.this));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        start=findViewById(R.id.act_fight_button_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFight();
            }
        });
        finish=findViewById(R.id.act_fight_button_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        image1=findViewById(R.id.act_fight_elf_player1);
        image1.setBackgroundResource(ElfSourceController.getBackgroundWithLevel(leftElf,leftGrade));
        image2=findViewById(R.id.act_fight_elf_player2);
        image2.setBackgroundResource(ElfSourceController.getBackgroundWithLevel(rightElf,rightGrade));
    }
    private void startFight() {
        list = new ArrayList<>();
        int attack=0;
        //判断精灵攻击强度
        Random luck=new Random();
        for (i = 0; leftHp>0&&rightHp>0; i++) {
            if(i%2==0) {
                int randomAttack=luck.nextInt(10);
                if(ElfSourceController.getAttack(leftPower,rightPower)/2>=1)
                    attack=ElfSourceController.getAttack(leftPower,rightPower)/2+luck.nextInt(ElfSourceController.getAttack(leftPower,rightPower)/2);
                else
                    attack=1;
                switch (randomAttack){
                    case 1:
                        list.add(ElfSourceController.getName(leftElf, leftGrade)+"的攻击MISS了");
                        attack=0;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        list.add(ElfSourceController.getName(leftElf, leftGrade)+"打出了普通一击");
                        break;
                    case 8:
                    case 9:
                        list.add(ElfSourceController.getName(leftElf, leftGrade)+"打出了会心一击");
                        attack*=2;
                        break;
                    case 0:
                        list.add(ElfSourceController.getName(leftElf, leftGrade)+"打出了致命一击");
                        attack*=5;
                        break;
                    default:
                }
                list.add("" + ElfSourceController.getName(leftElf, leftGrade) + "对" + ElfSourceController.getName(rightElf, rightGrade) + "造成了" +attack+ "%血量的伤害" );
                rightHp-=attack;
                if(rightHp<=0){
                    list.add(ElfSourceController.getName(leftElf, leftGrade)+"胜利!!!");
                    break;
                }
                list.add(ElfSourceController.getName(rightElf, rightGrade) +"还有" + rightHp+ "%血量");
            }
            else {
                if(ElfSourceController.getAttack(rightPower,leftPower)/2>=1)
                    attack=ElfSourceController.getAttack(rightPower,leftPower)/2+luck.nextInt(ElfSourceController.getAttack(rightPower,leftPower)/2);
                else
                    attack=1;
                int randomAttack=luck.nextInt(10);
                switch (randomAttack){
                    case 1:
                        list.add("" +ElfSourceController.getName(rightElf, rightGrade)+"的攻击MISS了");
                        attack=0;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        list.add("" +ElfSourceController.getName(rightElf, rightGrade)+"打出了普通一击");
                        break;
                    case 8:
                    case 9:
                        list.add("" +ElfSourceController.getName(rightElf, rightGrade)+"打出了会心一击");
                        attack*=2;
                        break;
                    case 0:
                        list.add("" +ElfSourceController.getName(rightElf, rightGrade)+"打出了致命一击");
                        attack*=5;
                        break;
                    default:
                }
                list.add("     " + "" + ElfSourceController.getName(rightElf, rightGrade) + "对" + ElfSourceController.getName(leftElf, leftGrade) + "造成了" + attack + "%血量的伤害" );
                leftHp -=attack;
                if(leftHp<=0){
                    list.add(ElfSourceController.getName(rightElf, rightGrade)+"胜利!!!");
                    break;
                }
                list.add(ElfSourceController.getName(leftElf, leftGrade) +"还有" + leftHp+ "%血量");
            }
        }
        FightTextAdapter adapter = new FightTextAdapter(FightActivity.this,list);
        mRecyclerView.setAdapter(adapter);
    }
}
