package Tresh;

public class Yacheika {
private int [] Position = new int[2];
private int steps;
private boolean start;
private boolean finish;
private boolean Value;

public void Yacheika() {
Position[0] = 0;
Position[1] = 0;
steps = 0;
start = false;
finish = false;
Value = true;
}
public void setValue (int Value) {
    if (Value == 0) {
        this.Value = true;
    }
    else {
        this.Value =false;
    }
}
public int getValue() {
    if (this.Value == true) {
        return 0;
    }
    else {
        return 1;
    }
}
public void setPosition(int PositionX, int PositionY ) {
    this.Position[0] = PositionX;
    this.Position[1] = PositionY;
    
}
public int[] getPosition() {
    return this.Position;
}
public void setStep(int step) {
    this.steps = step;
}
private int getSteps() {
    return this.steps;
}
public void setStart(boolean start){
    this.start = start;
}
public boolean getStart() {
    return this.start;
}
public void setFinish(boolean finish) {
    this.finish = finish;
}
private boolean getFinish() {
    return this.finish;
}
}