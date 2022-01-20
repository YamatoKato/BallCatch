final float GRAVITY=9.8;
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

void setup(){
  size(500,500);
  x=250;
}

void draw(){
  
  //gloval variable
  PImage      pGameGround;      //GAME Background
 
  //initialize the entire screen
  size(500,500);        //side 400pixcel x height600pixcel
 
  //Reads the GAME Background image data
  pGameGround =  loadImage("backgroundabc.png");
 
  //draw the background
  background( pGameGround );
  speed+=9.8/60+kasoku;
  y+=speed;
  smooth();
  noStroke();
  fill(200);
  ellipse(x,y,50,50);
  
  if(y>500-25){
    speed=-speed*0.6;
    y=500+25;
    fill(5);
    textSize(90);
     text("game over",10,60);
  }
  if(mouseX>x-25 && mouseX<x+25 &&
     mouseY>y-25 && mouseY<y+25){
     bingo=60;
     reset(); 
     kasoku+=0.05;
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
void reset(){
   score+=1;
      y=-50;
    speed=0;
    x=50+random(400);
    
}