import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_160902a extends PApplet {

final float GRAVITY=9.8f;
float speed=0;
float y;
float x;
int bingo=0;
float goodx=0;
float goody=0;
float kasoku=0;
int score=0;
PImage      pGameGround;
PFont       pGameFont; 

public void setup(){
  
  x=250;
}

public void draw(){
	  if( iGameStatus == STATUS_START ){
    //------------------------------------
    // ゲーム状態変数が「ゲーム開始前」の場合、ゲームタイトル画面を表示します
    //------------------------------------
    //変数初期化関数呼び出し
    initValue();
            
    background( pStartGround );
    //SPACEキーが押されていたら、ゲーム画面に進みます
    if( keyPressed  == true ){
      if( key == ' ' ){
        //SPACEキーが押されたら、ゲーム状態変数を「ゲーム中」に書き換えます
        iGameStatus = STATUS_PLAY;
      }
    }
  }

  
  //gloval variable
  PImage      pGameGround;      //GAME Background
 
  //initialize the entire screen
  size(500,500);        //side 400pixcel x height600pixcel
 
  //Reads the GAME Background image data
  pGameGround =  loadImage("backgroundabc.png");
 
  //draw the background
  background( pGameGround );
  speed+=9.8f/60+kasoku;
  y+=speed;
  smooth();
  noStroke();
  fill(200);
  ellipse(x,y,50,50);
  
  if(y>500-25){
    speed=-speed*0.6f;
    y=500+25;
    fill(5);
    textSize(90);
     text("game over",10,60);
  }
  if(mouseX>x-25 && mouseX<x+25 &&
     mouseY>y-25 && mouseY<y+25){
     bingo=60;
     reset(); 
     kasoku+=0.05f;
     goodx=mouseX;
     goody=mouseY;
     }
  if(bingo>0){
    noFill();
    stroke(0, 0, 255);
    text("good!",goodx,goody);
    textSize(50);
    text("Score:"+score,10,40);
    bingo-=1;
  }
  
}  
public void reset(){
   score+=1;
      y=-50;
    speed=0;
    x=50+random(400);
    
}
  public void settings() {  size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_160902a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
