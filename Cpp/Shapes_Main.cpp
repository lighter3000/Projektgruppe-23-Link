#ifndef Shapes_Main_cpp
#define Shapes_Main_cpp
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

//----------------------------------------------------------------------------------------

//Pixle

class Pixel : public Shape {

    protected:
        int _x;
        int _y;
        
        int _red;
        int _green;
        int _blue;
    public: 
        Pixel(int x=0, int y=0,int red=0,int green=0,int blue=0);
        void draw();

};

Pixel::Pixel(int x, int y,int red,int green,int blue){
    
    _position = Position(x,y);

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

void Pixel::draw(){
    setPixel(_position.x, _position.y, _red, _green,_blue);
}

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
int main() {
   
    //Rechteck
    Rectangle* blau = new Rectangle(100,200,50,50,0,0,255,10);
    blau->fill();
    
    //Dreick
    Triangle* weiss = new Triangle(750,250,500,150,600,250,255,255,255,10);
    weiss->draw();
      
    //Text
    StringText* stringText = new StringText(250, 0, "Hallo Welt", "Comic Sans", 24, 1,100,0,255);
    stringText->draw();

    //Linie
    Line* rot = new Line(250, 250, 250, 150, 255, 0, 0, 5);
    rot->draw();
    
    //Kreis   
    Circle* gruen = new Circle(400,250,50,0,255,0,2);
    gruen->draw();
    
    //Pixel
    setPixel(325,250,0,0,0);

    return 0;
}

#endif
