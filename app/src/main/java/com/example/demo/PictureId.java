package com.example.demo;


//这只是我闲着没事写来储存图片id的一个类。。。
public class PictureId {
    int[] pictureId = new int[27];

    PictureId() {
        pictureId[0] = R.drawable.pic1;
        pictureId[1] = R.drawable.pic2;
        pictureId[2] = R.drawable.pic3;
        pictureId[3] = R.drawable.pic4;
        pictureId[4] = R.drawable.pic5;
        pictureId[5] = R.drawable.pic6;
        pictureId[6] = R.drawable.pic7;
        pictureId[7] = R.drawable.pic8;
        pictureId[8] = R.drawable.pic9;
        pictureId[9] = R.drawable.pic10;
        pictureId[10] = R.drawable.pic11;
        pictureId[11] = R.drawable.pic12;
        pictureId[12] = R.drawable.pic13;
        pictureId[13] = R.drawable.pic14;
        pictureId[14] = R.drawable.pic15;
        pictureId[15] = R.drawable.pic16;
        pictureId[16] = R.drawable.pic17;
        pictureId[17] = R.drawable.pic18;
        pictureId[18] = R.drawable.pic19;
        pictureId[19] = R.drawable.pic20;
        pictureId[20] = R.drawable.pic21;
        pictureId[21] = R.drawable.pic22;
        pictureId[22] = R.drawable.pic23;
        pictureId[23] = R.drawable.pic24;
        pictureId[24] = R.drawable.pic25;
        pictureId[25] = R.drawable.ic_content_background;
        pictureId[26] = R.drawable.ic_main_background;
    }

    public int getPictureId(int num){
        return pictureId[num-1];
    }

}
