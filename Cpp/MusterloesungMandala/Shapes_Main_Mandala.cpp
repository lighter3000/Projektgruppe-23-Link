#ifndef Shapes_Main_Mandala_cpp
#define Shapes_Main_Mandala_cpp
#include "DrawGUI.cpp"
#include <cmath>

#include <set>
#include <iterator>
#include <complex>

#include <iostream>
#include <random>

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
    if(red>255){
        _red = 255;
    }
    
    _green = green;
    if(green>255){
        _green = 255;
    }

    _blue = blue;
    if(blue>255){
        _blue = 255;
    }
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
    void fill();
    //double area();
    string shapeType();

};

Triangle::Triangle(int x1P, int y1P,int x2P, int y2P,int x3P, int y3P, int red,int green,int blue, int lineWidth){
    
    _position = Position(x1P,y1P, x2P, y2P, x3P, y3P);

    _lineWidth = lineWidth;

      _red = red;
    if(red>255){
        _red = 255;
    }
    
    _green = green;
    if(green>255){
        _green = 255;
    }

    _blue = blue;
    if(blue>255){
        _blue = 255;
    }
}

string Triangle::shapeType(){

    string s = "Das ist ein Dreieck";

    return s;

}

void Triangle::draw(){
    setDrawTriangle(_position.x, _position.y, _position.x2, _position.y2, _position.x3, _position.y3, _red, _green, _blue, _lineWidth);
}
void Triangle::fill(){
    setFillTriangle(_position.x, _position.y, _position.x2, _position.y2, _position.x3, _position.y3, _red, _green, _blue, _lineWidth);
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
    void fill();
    //double area();
    string shapeType();

};

Circle::Circle(int xP, int yP, int radius, int red,int green, int blue, int lineWidth){

    _position = Position(xP,yP);

    _radius = radius;
    _lineWidth = lineWidth;

     _red = red;
    if(red>255){
        _red = 255;
    }
    
    _green = green;
    if(green>255){
        _green = 255;
    }

    _blue = blue;
    if(blue>255){
        _blue = 255;
    }
}

string Circle::shapeType(){

    string s = "Das ist ein Kreis";

    return s;

}

void Circle::draw(){
    setDrawCircle(_position.x, _position.y, _radius, _red, _green, _blue, _lineWidth);
}
void Circle::fill(){
    setFillCircle(_position.x, _position.y, _radius, _red, _green, _blue, _lineWidth);
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
    if(red>255){
        _red = 255;
    }
    
    _green = green;
    if(green>255){
        _green = 255;
    }

    _blue = blue;
    if(blue>255){
        _blue = 255;
    }
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
    void fill();
    //double area();
    string shapeType();

};

Rectangle::Rectangle(int x, int y, int width,int height,int red,int green,int blue, int lineWidth){

    _position = Position(x,y);
    _width = width;
    _height = height;
      _red = red;
    if(red>255){
        _red = 255;
    }
    
    _green = green;
    if(green>255){
        _green = 255;
    }

    _blue = blue;
    if(blue>255){
        _blue = 255;
    }
    _lineWidth = lineWidth;
}

string Rectangle::shapeType(){

    string s = "Das ist ein Rectangle";

    return s;

}

void Rectangle::draw(){
   setDrawRectangle(_position.x, _position.y, _width, _height, _red, _green, _blue, _lineWidth);
}

void Rectangle::fill(){
   setFillRectangle(_position.x, _position.y, _width, _height, _red, _green, _blue, _lineWidth);
}
//----------------------------------------------------------------------------------------
//Main
int main() {   

    //Circle

    Circle* c0 = new Circle(150,100,200,0,0,0,5);
    c0->draw();

    Circle* c1 = new Circle(150,100,200,200,0,0,5);
    c1->fill();


    //Triangle

    int triangle_position_x[10];
    triangle_position_x[0] = 350;
    triangle_position_x[1] = 450;
    triangle_position_x[2] = 490;
    triangle_position_x[3] = 450;
    triangle_position_x[4] = 350;
    triangle_position_x[5] = 250;
    triangle_position_x[6] = 210;
    triangle_position_x[7] = 250;
    triangle_position_x[8] = 350;
    triangle_position_x[9] = 450;

    int triangle_position_y[10];
    triangle_position_y[0] = 160;
    triangle_position_y[1] = 200;
    triangle_position_y[2] = 300;
    triangle_position_y[3] = 400;
    triangle_position_y[4] = 440;
    triangle_position_y[5] = 400;
    triangle_position_y[6] = 300;
    triangle_position_y[7] = 200;
    triangle_position_y[8] = 160;
    triangle_position_y[9] = 200;

    for(int i = 0; i<8; i++){
        Triangle* t1 = new Triangle(triangle_position_x[i], triangle_position_y[i], triangle_position_x[i+1], triangle_position_y[i+1], triangle_position_x[i+2], triangle_position_y[i+2], 220, 220, 0, 3);
        t1->draw();
    }


    //Circle

    int circle_position_x;
    int circle_position_y;

    Circle* c001 = new Circle(250,100,100,0,0,255,3);
    c001->draw();
    Circle* c002 = new Circle(150,200,100,0,0,255,3);
    c002->draw();
    Circle* c003 = new Circle(350,200,100,0,0,255,3);
    c003->draw();
    Circle* c004 = new Circle(250,300,100,0,0,255,3);
    c004->draw();

    circle_position_x = 179;
    for(int i = 1; i <= 2; i++){
        circle_position_y = 129;
        for(int j = 1; j <= 2; j++){
            Circle* c06 = new Circle(circle_position_x,circle_position_y,100,0,0,255,3);
            c06->draw();
            circle_position_y += 142;
        }
        circle_position_x = circle_position_x + 142;
    }


    return 0;
}

#endif
