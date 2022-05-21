import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
	/**
   * Assignment: 5.11 Processing Task 9 - Arrays
   * Author: Lydia He
   * Date: Fri, May 13, 2022
   * Description: Create a sketch that simulates snow falling.
   */

  // Variables
  float playerX = 200;
  float playerY = 380;
  float[] circleX = new float[15];
  float[] circleY = new float[15];
  boolean[] ballHideStatus = new boolean[15];
  int fallSpeed = 2;
  int lives = 3;

  public void settings() {
    size(400, 400);
  }
  
  public void setup() {
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }
  }

  public void draw() {
  background(0);

  // Blue Player Circle
  fill(37, 150, 190);
  stroke(37, 150, 190);
  ellipse(playerX, playerY, 20, 20);

    for (int i = 0; i < circleY.length; i++) {
      float circleX = width * i / circleY.length;
      fill(255);
      stroke(255);
      ellipse(circleX, circleY[i], 20, 20);
  
      circleY[i] += fallSpeed;
  
      if (circleY[i] > height) {
        circleY[i] = 0;
      }
    }

  if (keyPressed) {
    // The snow falls slower when the up arrow is pressed
    if (keyCode == UP) {
      fallSpeed = 1;
    }
    // When the down arrow is pressed on the keyboard, the snow falls faster
    if (keyCode == DOWN) {
      fallSpeed = 3;
    }
  }

  // 3 lives
  // Add a three squares at the top right of the screen to indicate player lives.  The player loses a life everytime it collides with snowflake.  The game ends when all lives are lost and the screen clears to white.
  if (lives == 3) {
    fill(255, 0, 0);
    stroke(255, 192, 203);
    rect(380, 10, 10, 10);
    rect(360, 10, 10, 10);
    rect(340, 10, 10, 10);
  }
    
  if (lives == 2) {
    fill(255, 0, 0);
    stroke(255, 192, 203);
    rect(380, 10, 10, 10);
    rect(360, 10, 10, 10);
  }

  if (lives == 1) {
    fill(255, 0, 0);
    stroke(255, 192, 203);
    rect(380, 10, 10, 10);
  }

  // The game ends when all lives are lost and the screen clears to white.
  if (lives == 0) {
    fill(255);
    stroke(255);
    rect(0, 0, 400, 400);
  }
  
  /** Click on snowflakes and make them disappear 
  if (mousePressed == true) {
    if (mouseX >= circleX - 10 && mouseX <= circleX + 10 && mouseY >= circleY[i] - 10 && mouseY <= circleY[i] + 10) {
      ballHideStatus[i] = false;
    }
  }
  */
    
  /** The player loses a life everytime it collides with snowflake
  if (playerX + 10 == circleX + 10 || playerY + 10 == circleY + 10) {
    lives -=1; 
  }
  */
    
  // Controlled by the user with the asdw keys. (left, down, right , up)
  if (key == 'w') {
    playerY -= 2;
  }

  if (key == 'a') {
    playerX -= 2;
  }

  if (key == 's') {
    playerY += 2;
  }

  if (key == 'd') {
    playerX += 2;  
  }
    
}
}