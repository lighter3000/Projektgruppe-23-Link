#ifndef Shapes_Main_RGB_cpp
#define Shapes_Main_RGB_cpp
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
   
//Circle(int x, int y, int radius,int red,int green,int blue, int lineWidth)
Circle* c01 = new Circle(70,50,50,0,0,0,3);
    c01->draw();
    delete c01;
    Circle* c02 = new Circle(270,50,50,0,0,0,3);
    c02->draw();
    delete c02;
    Circle* c03 = new Circle(470,50,50,0,0,0,3);
    c03->draw();
    delete c03;
    Circle* c04 = new Circle(670,50,50,0,0,0,3);
    c04->draw();
    delete c04;

    Circle* c11 = new Circle(70,50,50,0,255,255,3);
    c11->fill();
    delete c11;
     Circle* c12 = new Circle(270,50,50,0,127,255,3);
    c12->fill();
    delete c12;
     Circle* c13 = new Circle(470,50,50,0,0,255,3);
    c13->fill();
    delete c13;
     Circle* c14 = new Circle(670,50,50,127,0,255,3);
    c14->fill();
    delete c14;

    //Rectangle(int x, int y, int width,int height,int red,int green,int blue, int lineWidth)
    Rectangle* r01 = new Rectangle(70,250,100,100,0,0,0,3);
    r01->draw();
    delete r01;
    Rectangle* r02 = new Rectangle(270,250,100,100,0,0,0,3);
    r02->draw();
    delete r02;
    Rectangle* r03 = new Rectangle(470,250,100,100,0,0,0,3);
    r03->draw();
    delete r03;
    Rectangle* r04 = new Rectangle(670,250,100,100,0,0,0,3);
    r04->draw();
    delete r04;

    Rectangle* r11 = new Rectangle(70,250,100,100,255,0,255,3);
    r11->fill();
    delete r11;
    Rectangle* r12 = new Rectangle(270,250,100,100,255,0,127,3);
    r12->fill();
    delete r12;
    Rectangle* r13 = new Rectangle(470,250,100,100,255,0,0,3);
    r13->fill();
    delete r13;
    Rectangle* r14 = new Rectangle(670,250,100,100,255,127,0,3);
    r14->fill();
    delete r14;

    //Triangle(int x1P, int y1P, int x2P, int y2P, int x3P, int y3P,int red,int green,int blue, int lineWidth)
    Triangle* t01 = new Triangle(120, 450, 70, 550, 170, 550, 0, 0, 0, 3);
    t01->draw();
    delete t01;
    Triangle* t02 = new Triangle(320, 450, 270, 550, 370, 550, 0, 0, 0, 3);
    t02->draw();
    delete t02;
    Triangle* t03 = new Triangle(520, 450, 470, 550, 570, 550, 0, 0, 0, 3);
    t03->draw();
    delete t03;
    Triangle* t04 = new Triangle(720, 450, 670, 550, 770, 550, 0, 0, 0, 3);
    t04->draw();
    delete t04;

    Triangle* t11 = new Triangle(120, 450, 70, 550, 170, 550, 255, 255, 0, 3);
    t11->fill();
    delete t11;
    Triangle* t12 = new Triangle(320, 450, 270, 550, 370, 550, 127, 255, 0, 3);
    t12->fill();
    delete t12;
    Triangle* t13 = new Triangle(520, 450, 470, 550, 570, 550, 0, 255, 0, 3);
    t13->fill();
    delete t13;
    Triangle* t14 = new Triangle(720, 450, 670, 550, 770, 550, 0, 255, 127, 3);
    t14->fill();
    delete t14;

    //Text (int xP, int yP,string text, string fontType, int fontSize, int bold_1or0, int red,int green,int blue)
    StringText* circle01 = new StringText(90,160, " 0,255,255 ", "Comic Sans", 13, 1,0,0,0);
    StringText* circle21 = new StringText(90,180, " Türkis", "Comic Sans", 13, 1,0,0,0);
    circle01->draw();
    circle21->draw();
    delete circle01;
    delete circle21;

    StringText* circle02 = new StringText(290,160, " 0,127,255 ", "Comic Sans", 13, 1,0,0,0);
    StringText* circle22 = new StringText(290,180, " Hellblau", "Comic Sans", 13, 1,0,0,0);
    circle02->draw();
    circle22->draw();
    delete circle02;
    delete circle22;
    StringText* circle03 = new StringText(490,160, " 0,0,255 ", "Comic Sans", 13, 1,0,0,0);
    StringText* circle23 = new StringText(490,180, " Blau", "Comic Sans", 13, 1,0,0,0);
    circle03->draw();
    circle23->draw();
    delete circle03;
    delete circle23;
    StringText* circle04 = new StringText(690,160, " 127,0,255 ", "Comic Sans", 13, 1,0,0,0);
    StringText* circle24 = new StringText(690,180, " Violett", "Comic Sans", 13, 1,0,0,0);
    circle04->draw();
    circle24->draw();
    delete circle04;
    delete circle24;
//-----------------------------------------------------------------------------------------------
    StringText* rectagle01 = new StringText(90,360, " 255,0,255 ", "Comic Sans", 13, 1,0,0,0);
    StringText* rectagle21 = new StringText(90,380, " Pink", "Comic Sans", 13, 1,0,0,0);
    rectagle01->draw();
    rectagle21->draw();
    delete rectagle01;
    delete rectagle21;

    StringText* rectagle02 = new StringText(290,360, " 255,0,127 ", "Comic Sans", 13, 1,0,0,0);
    StringText* rectagle22 = new StringText(290,380, " Magenta", "Comic Sans", 13, 1,0,0,0);
    rectagle02->draw();
    rectagle22->draw();
    delete rectagle02;
    delete rectagle22;

    StringText* rectagle03 = new StringText(490,360, " 255,0,0 ", "Comic Sans", 13, 1,0,0,0);
    StringText* rectagle23 = new StringText(490,380, " Rot", "Comic Sans", 13, 1,0,0,0);
    rectagle03->draw();
    rectagle23->draw();
    delete rectagle03;
    delete rectagle23;

    StringText* rectagle04 = new StringText(690,360, " 255,127,0 ", "Comic Sans", 13, 1,0,0,0);
    StringText* rectagle24 = new StringText(690,380, " Orange", "Comic Sans", 13, 1,0,0,0);
    rectagle04->draw();
    rectagle24->draw();
    delete rectagle04;
    delete rectagle24;
//-----------------------------------------------------------------------------------------------

    StringText* triangle01 = new StringText(90,560, " 255,255,0 ", "Comic Sans", 13, 1,0,0,0);
    StringText* triangle21 = new StringText(90,580, " Gelb", "Comic Sans", 13, 1,0,0,0);
    triangle01->draw();
    triangle21->draw();
    delete triangle01;
    delete triangle21;

    StringText* triangle02 = new StringText(290,560, " 127,255,0 ", "Comic Sans", 13, 1,0,0,0);
    StringText* triangle22 = new StringText(290,580, " Grün-Gelb", "Comic Sans", 13, 1,0,0,0);
    triangle02->draw();
    triangle22->draw();
    delete triangle02;
    delete triangle22;

    StringText* triangle03 = new StringText(490,560, " 0,255,0 ", "Comic Sans", 13, 1,0,0,0);
    StringText* triangle23 = new StringText(490,580, " Grün", "Comic Sans", 13, 1,0,0,0);
    triangle03->draw();
    triangle23->draw();
    delete triangle03;
    delete triangle23;

    StringText* triangle04 = new StringText(690,560, " 0,255,127 ", "Comic Sans", 13, 1,0,0,0);
    StringText* triangle24 = new StringText(690,580, " Mint-Grün", "Comic Sans", 13, 1,0,0,0);
    triangle04->draw();
    triangle24->draw();
    delete triangle04;
    delete triangle24;
    return 0;
}

#endif
