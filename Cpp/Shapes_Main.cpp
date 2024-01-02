#ifndef Shapes_Main_cpp
#define Shapes_Main_cpp
#include "DrawGUI.cpp"
#include <cmath>

#include <set>
#include <iterator>
#include <complex>

using namespace std;
//----------------------------------------------------------------------------------------
//Shape
struct Position{
    int x;
    int y;
    int x2;
    int y2;
    int x3;
    int y3;
    
    Position(int x_=0, int y_=0, int x2_=0, int y2_=0, int x3_=0, int y3_=0){
        x=x_;
        y=y_;
        x2=x2_;
        y2=y2_;
        x3=x3_;
        y3=y3_;}
};

class Shape{

protected:
  Position _position;
  int _red;
  int _green;
  int _blue;

public:
virtual double area();
virtual string shapeType();
void typeZeigen(Shape*);
void floodFill(int,int,int,int,int,int,int);
void floodFill2(int,int,int,int,int,int,int);

};

void Shape::typeZeigen(Shape* s){

cout<<s->shapeType()<<endl;

}

string Shape::shapeType(){

string s = "Das ist ein Shape";

return s;
}

double Shape::area(){


return 0;

}

void Shape::floodFill(int x,int y,int red,int green,int blue,int jframeheight,int jframewidth)
{
    
    
    if((x > jframewidth) || (y > jframeheight) || (x < 0) || (y < 0)
    ||(getPixel(x, y).compare("238,238,238") != 0)){
        
        return;
        
    } else if ((x < jframewidth) && (y < jframeheight) &&
      (getPixel(x, y).compare("238,238,238") == 0)){
        
        setPixel(x,y,red,green,blue);
        
         floodFill(x+1,y,red,green,blue,jframeheight,jframewidth); // east
         floodFill(x,y+1,red,green,blue,jframeheight,jframewidth); // south
         floodFill(x-1,y,red,green,blue,jframeheight,jframewidth); // west
         floodFill(x,y-1,red,green,blue,jframeheight,jframewidth); // north
        
  }
    }
    
void Shape::floodFill2(int x,int y,int red,int green,int blue,int jframewidth,int jframeheight){
    
    set<Position*> Points;
    set<Position*>::iterator itr;
    
    Position* p = new Position(x,y);
    
    Points.insert(p);
    
    while(!Points.empty()){
        
        itr = Points.begin();
        Points.erase(itr);
        
        Position* pbegin = *itr;
        
        if((pbegin->x < jframewidth) && (pbegin->x > 0)&&
        (pbegin->y < jframeheight) && (pbegin->y > 0) &&
      (getPixel(pbegin->x,pbegin->y).compare("238,238,238") == 0)){
            
            setPixel(pbegin->x,pbegin->y,red,green,blue);
            
            Position* pright = new Position(pbegin->x+1,pbegin->y);
            Points.insert(pright);
            Position* pleft = new Position(pbegin->x-1,pbegin->y);
            Points.insert(pleft);
            Position* psouth = new Position(pbegin->x,pbegin->y+1);
            Points.insert(psouth);
            Position* pnorth = new Position(pbegin->x,pbegin->y-1);
            Points.insert(pnorth);
            
        }
        
    }
    
}

//----------------------------------------------------------------------------------------
//Line
class Line : public Shape {

protected:

    int _x1P;
    int _y1P;
    int _x2P;
    int _y2P;
    
    int _lineWidth;

    int _red;
    int _green;
    int _blue;

public:
    Line(int x1P=0, int y1P=0, int x2P=0, int y2P=0, int red=0,int green=0,int blue=0, int _lineWidth=1);
    void draw();
    //double area();
    string shapeType();

};

Line::Line(int x1P, int y1P,int x2P, int y2P, int red,int green,int blue, int lineWidth){
    
    _position = Position(x1P,y1P, x2P, y2P);

    _lineWidth = lineWidth;

    _red = red;
    _green = green;
    _blue = blue;
}

string Line::shapeType(){

    string s = "Das ist eine Linie";

    return s;

}

void Line::draw(){
    setLine(_position.x, _position.y, _position.x2, _position.y2, _red, _green, _blue, _lineWidth);

}


//----------------------------------------------------------------------------------------
//Triangle
class Triangle : public Shape {

protected:

    int _x1P;
    int _y1P;
    int _x2P;
    int _y2P;
    int _x3P;
    int _y3P;
    
    int _lineWidth;

    int _red;
    int _green;
    int _blue;

public:
    Triangle(int x1P=0, int y1P=0, int x2P=0, int y2P=0, int x3P=0, int y3P=0, int red=0,int green=0,int blue=0, int _lineWidth=1);
    void draw();
    //double area();
    string shapeType();

};

Triangle::Triangle(int x1P, int y1P,int x2P, int y2P,int x3P, int y3P, int red,int green,int blue, int lineWidth){
    
    _position = Position(x1P,y1P, x2P, y2P, x3P, y3P);

    _lineWidth = lineWidth;

    _red = red;
    _green = green;
    _blue = blue;
}

string Triangle::shapeType(){

    string s = "Das ist ein Dreieck";

    return s;

}

void Triangle::draw(){
    setTriangle(_position.x, _position.y, _position.x2, _position.y2, _position.x3, _position.y3, _red, _green, _blue, _lineWidth);
}

//----------------------------------------------------------------------------------------
//Circle
class Circle : public Shape {

protected:

    int _xP;
    int _yP;
    
    int _radius;
    int _lineWidth;

    int _red;
    int _green;
    int _blue;

public:
    Circle(int xP=0, int yP=0, int radius=0, int red=0, int green=0,int blue=0, int lineWidth=1);
    void draw();
    //double area();
    string shapeType();

};

Circle::Circle(int xP, int yP, int radius, int red,int green, int blue, int lineWidth){

    _position = Position(xP,yP);

    _radius = radius;
    _lineWidth = lineWidth;

    _red = red;
    _green = green;
    _blue = blue;
}

string Circle::shapeType(){

    string s = "Das ist ein Kreis";

    return s;

}

void Circle::draw(){
    setCircle(_position.x, _position.y, _radius, _red, _green, _blue, _lineWidth);
}

//----------------------------------------------------------------------------------------
//StringText
class StringText : public Shape {

protected:

    int _xP;
    int _yP;

    string _text;
    string _fontType;
    int _fontSize;
    int _bold_1or0;

    int _red;
    int _green;
    int _blue;

public:
    StringText(int xP=0, int yP=0, string text="", string fontType="", int fontSize=0, int bold_1or0=0, int red=0,int green=0,int blue=0);
    void draw();
    //double area();
    string shapeType();

};

StringText::StringText(int xP, int yP, string text, string fontType, int fontSize, int bold_1or0, int red,int green,int blue){

    _position = Position(xP,yP);

    _text = text;
    _fontType = fontType;
    _fontSize = fontSize;
    _bold_1or0 = bold_1or0;

    _red = red;
    _green = green;
    _blue = blue;
}

string StringText::shapeType(){

    string s = "Das ist ein Text";

    return s;

}

void StringText::draw(){

    setStringText(_position.x, _position.y, _text, _fontType, _fontSize, _bold_1or0, _red, _green, _blue);

}

//----------------------------------------------------------------------------------------
//Rectangle
class Rectangle : public Shape {

protected:

    int _width;
    int _height;
    
    int _lineWidth;

public:
    Rectangle(int x=0, int y=0, int width=0,int height=0,int red=0,int green=0,int blue=0, int lineWidth=1);
    void draw();
    //double area();
    string shapeType();

};

Rectangle::Rectangle(int x, int y, int width,int height,int red,int green,int blue, int lineWidth){

    _position = Position(x,y);
    _width = width;
    _height = height;
    _red = red;
    _green = green;
    _blue = blue;
    _lineWidth = lineWidth;
}

string Rectangle::shapeType(){

    string s = "Das ist ein Rectangle";

    return s;

}

void Rectangle::draw(){

    int i = _position.x;
    int w = _width;


//Pixel
    while(w >= 0){

        setPixel(i,_position.y,_red,_green,_blue);

        setPixel(i,_position.y+_height,_red,_green,_blue);

        i++;

        w--;
    }

    int i2 = _position.y;
    int h  = _height;

    while(h >= 0){

        setPixel(_position.x,i2,_red,_green,_blue);

        setPixel(_position.x+_width,i2,_red,_green,_blue);

        i2++;

        h--;
    }
    
   //setRectangle(_position.x, _position.y, _width, _height, _red, _green, _blue, _lineWidth);
}

//----------------------------------------------------------------------------------------
//MandelBrot
class MandelBrot:public Shape {
 
public:
  MandelBrot();
  void draw(int,int,int);
  string shapeType();
  int value(int,int,int,int,int);

};

MandelBrot::MandelBrot(){
    
  
}

string MandelBrot::shapeType(){

string s = "Das ist ein Mandelbrot";

return s;

}

int MandelBrot::value (int x, int y,int width,int height,int iteration)  {
    complex<float> point((float)x/width-1.5, (float)y/height-0.5);
    complex<float> z(0, 0);
    int nb_iter = 0;
    while (abs (z) < 2 && nb_iter <= iteration) {
        z = z * z + point;
        nb_iter++;
    }
    if (nb_iter < iteration)
       return (255*nb_iter)/20;
    else
       return 0;
}

void MandelBrot::draw(int width,int height,int iteration){
    
 for (int i = 0; i < width; i++) {
   for (int j = 0; j < height; j++)  {
          
          int val = value(i, j,width,height,iteration);
          
          setPixel(i,j,0,0,val);
                
            }
        }
}

//----------------------------------------------------------------------------------------
int main() {
   
    //Rechteck
    Rectangle* blau = new Rectangle(100,200,50,50,0,0,255,10);
    blau->draw();
    blau->floodFill2(150,250,0,0,255,getJPanelWidth(),getJPanelHeight());

        
    //Text
    StringText* stringText = new StringText(250, 0, "Hallo Welt", "Arial", 24, 1,100,0,255);
    stringText->draw();

    //Linie
    Line* rot = new Line(250, 250, 250, 150, 255, 0, 0, 10);
    rot->draw();
    
    
    //Circle   
        Circle* gruen = new Circle(400,250,50,0,255,0,5);
        gruen->draw();
 
    Triangle* weiss = new Triangle(750, 250, 500, 150, 600, 285, 255, 255, 255, 5);
    weiss->draw();

    //pixel
        setPixel(325,250,0,0,0);
   
    return 0;
}

#endif
