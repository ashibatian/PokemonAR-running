package org.pokemonrun.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cover")
public class Cover {
    @Id
    public String momentid;

    public String text;

    public String timestamp;

    public String username;
    

    public Cover(){}
    public Cover(String text, String timestamp, String username, byte[] pic1, byte[] pic2, byte[] pic3, byte[] pic4, byte[] pic5, byte[] pic6, byte[] pic7, byte[] pic8, byte[] pic9)
    {
        this.text=text;
        this.timestamp=timestamp;
        this.username=username;
        this.pic1=pic1;
        this.pic2=pic2;
        this.pic3=pic3;
        this.pic4=pic4;
        this.pic5=pic5;
        this.pic6=pic6;
        this.pic7=pic7;
        this.pic8=pic8;
        this.pic9=pic9;
    }
}
