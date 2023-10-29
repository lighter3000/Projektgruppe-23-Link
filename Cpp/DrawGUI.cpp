#ifndef DrawGUI_cpp
#define DrawGUI_cpp
#include <iostream>
#include <string>
#include <fstream>

using namespace std;

char* xyDecToHex(int Value)          // Wandeln X,Y-Decimal zu HEX um
{
    char *CharRes = new (char);
    sprintf(CharRes, "%X", Value);
    
    char *CharRes2 = new (char);
    
    if(Value > -1 && Value < 16){
        
        *CharRes2 = *CharRes;
        *CharRes = 48;
        CharRes++;
        *CharRes = 48;
        CharRes++;
        *CharRes = *CharRes2;
        CharRes++;
        *CharRes='\0';
        CharRes -= 3;
        
    }else if(Value > 15 && Value < 256){
        
        *CharRes2 = *CharRes;
        CharRes++;
        CharRes2++;
        *CharRes2 = *CharRes;
        CharRes--;
        CharRes2--;
        *CharRes = 48;
        CharRes++;
        *CharRes = *CharRes2;
        CharRes++;
        CharRes2++;
        *CharRes = *CharRes2;
        CharRes++;
        *CharRes='\0';
        CharRes -= 3;
    }
    return CharRes;
}

char* rgbDecToHex(int Value)       // Wandeln R,G,B-Decimal zu HEX um
{
    char *CharRes = new (char);
    sprintf(CharRes,"%X", Value);
    
    char *CharRes2 = new (char);
    
    if(Value > -1 && Value < 16){
        
        *CharRes2 = *CharRes;
        *CharRes = 48;
        CharRes++;
        *CharRes = *CharRes2;
        CharRes++;
        *CharRes='\0';
        CharRes -= 2;
    }
    
    return CharRes;
}

string hexAll(int x,int y,int red,int green,int blue)  // X,Y,R,G,B-Werte zusammenfügen
{
    string hexall= "";
    
    string strx = xyDecToHex(x);
    string stry = xyDecToHex(y);
    string strred = rgbDecToHex(red);
    string strgreen = rgbDecToHex(green);
    string strblue = rgbDecToHex(blue);
    
    hexall = strx+stry+strred+strgreen+strblue;
    
    return hexall;
}

string hexXY(int x,int y)  // X,Y-Werte zusammenfügen
{
    string hexxy= "";
    
    string strx = xyDecToHex(x);
    string stry = xyDecToHex(y);
    
    hexxy = strx+stry;
    
    return hexxy;
}

void sendhexAllToSwing(int x,int y,int red,int green,int blue)  // Schicken die X,Y,R,G,B-Werte nach Java-Swing
{
   cout<<hexAll(x,y,red,green,blue)<<"\n";  // cout wird zwischen gespeicherchert
   cout.flush();                            //flush() gibt cout aus und leer den puffer,zuvermeidung von Overhead, erhöht efizenz. Overhead: beinhaltet zusatzinformationen die für Übermittlungen und Speicherungen benötigt werden, welche uneffizent ist und vermieden werden sollte
   
}

void sendhexXYToSwing(int x,int y)   // Schicken die X,Y-Werte nach Java-Swing
{
   cout<<hexXY(x,y)<<"\n";
   cout.flush();
    
}

//----------------------------------------------------------------------------------------
//Pixel
/*
void setPixel(int x,int y,int red,int green,int blue)//
{
    string stringPixel= "";

    std::string strXP = std::to_string(x);
    std::string strYP = std::to_string(y);

    std::string strRed = std::to_string(red);
    std::string strGreen = std::to_string(green);
    std::string strBlue = std::to_string(blue);

    stringPixel = "pixel: x(" + strXP + "), y(" + strYP + "), red(" + strRed + "), green(" + strGreen + "), blue(" + strBlue + ")";

    cout<<stringPixel<<"\n";
    cout.flush();
}
 */
void setPixel(int x,int y,int red,int green,int blue)//
{
sendhexAllToSwing(x,y,red,green,blue);
}
 /*
std::string getPixel(int x,int y)   //
{
    sendhexXYToSwing(x,y);
    string rgb;

    cin>>rgb;

    cout<<rgb<<"\n";

    return rgb;
}
*/

std::string getPixel(int x,int y)   //
{
    //Anfrage
    string request= "";
        
    std::string strX = std::to_string(x);
    std::string strY = std::to_string(y);
    
    request= "getPixel: x("+ strX + "), y(" + strY + ")";
    cout<<request<<"\n";
    cout.flush();
    
    //Antwort
    string rgb;
    cin>>rgb;

    cout<<rgb<<"\n";

    return rgb;
   
}

//----------------------------------------------------------------------------------------
//Line
void setLine(int x1P, int y1P, int x2P, int y2P,
             int red,int green,int blue,
             int lineWidth)//
{
    string strLine= "";
    
    std::string strX1P = std::to_string(x1P);
    std::string strY1P = std::to_string(y1P);
    
    std::string strX2P = std::to_string(x2P);
    std::string strY2P = std::to_string(y2P);
    
    std::string strLineWidth = std::to_string(lineWidth);

    std::string strRed = std::to_string(red);
    std::string strGreen = std::to_string(green);
    std::string strBlue = std::to_string(blue);

    strLine = "line: x1(" + strX1P + "), y1(" + strY1P + "), x2(" + strX2P + "), y2(" + strY2P + "), red(" + strRed + "), green(" + strGreen + "), blue(" + strBlue + "), lineWidth(" + strLineWidth +")";

    cout<<strLine<<"\n";
    cout.flush();
}



//----------------------------------------------------------------------------------------
//Triangle
void setTriangle(int x1P, int y1P, int x2P, int y2P, int x3P, int y3P,
             int red,int green,int blue,
             int lineWidth)//
{
    string strTriangle= "";
    
    std::string strX1P = std::to_string(x1P);
    std::string strY1P = std::to_string(y1P);
    
    std::string strX2P = std::to_string(x2P);
    std::string strY2P = std::to_string(y2P);
    
    std::string strX3P = std::to_string(x3P);
    std::string strY3P = std::to_string(y3P);
    
    std::string strLineWidth = std::to_string(lineWidth);

    std::string strRed = std::to_string(red);
    std::string strGreen = std::to_string(green);
    std::string strBlue = std::to_string(blue);

    strTriangle = "triangle: x1(" + strX1P + "), y1(" + strY1P + "), x2(" + strX2P + "), y2(" + strY2P + "), x3(" + strX3P + "), y3(" + strY3P + "), red(" + strRed + "), green(" + strGreen + "), blue(" + strBlue + "), lineWidth(" + strLineWidth +")";

    cout<<strTriangle<<"\n";
    cout.flush();
}

//----------------------------------------------------------------------------------------
//Rectangle
void setRectangle(int xP, int yP, int width, int height,
                  int red,int green,int blue,
                  int lineWidth)//
{
    string strRectangle= "";
    
    std::string strXP = std::to_string(xP);
    std::string strYP = std::to_string(yP);
    
    std::string strWidth = std::to_string(width);
    std::string strHeight = std::to_string(height);
    
    std::string strLineWidth = std::to_string(lineWidth);

    std::string strRed = std::to_string(red);
    std::string strGreen = std::to_string(green);
    std::string strBlue = std::to_string(blue);

    strRectangle = "rectangle: x(" + strXP + "), y(" + strYP + "), width(" + strWidth + "), height(" + strHeight + "), red(" + strRed + "), green(" + strGreen + "), blue(" + strBlue + "), lineWidth(" + strLineWidth +")";

    cout<<strRectangle<<"\n";
    cout.flush();
}

//----------------------------------------------------------------------------------------
//Circle
void setCircle(int xP, int yP, int radius,
                  int red,int green,int blue,
                  int lineWidth)//
{
    string strCircle= "";
    
    std::string strXP = std::to_string(xP);
    std::string strYP = std::to_string(yP);
    
    std::string strRadius = std::to_string(radius);
    
    std::string strLineWidth = std::to_string(lineWidth);

    std::string strRed = std::to_string(red);
    std::string strGreen = std::to_string(green);
    std::string strBlue = std::to_string(blue);

    strCircle = "circle: x(" + strXP + "), y(" + strYP + "), radius(" + strRadius + "), red(" + strRed + "), green(" + strGreen + "), blue(" + strBlue + "), lineWidth(" + strLineWidth +")";

    cout<<strCircle<<"\n";
    cout.flush();
}
//----------------------------------------------------------------------------------------
//StringText
void setStringText(int xP, int yP,
                   string text, string fontType,
                   int fontSize, int bold_1or0,
                   int red,int green,int blue)//
{

    string stringText= "";

    std::string strXP = std::to_string(xP);
    std::string strYP = std::to_string(yP);

    std::string strRed = std::to_string(red);
    std::string strGreen = std::to_string(green);
    std::string strBlue = std::to_string(blue);

    std::string strBold_1or0 = std::to_string(bold_1or0);
    std::string strFontSize = std::to_string(fontSize);


    stringText = "string: x(" + strXP + "), y(" + strYP + "), red(" + strRed + "), green(" + strGreen + "), blue(" + strBlue + "), bold(" + strBold_1or0 + "), fontSize(" + strFontSize + "), fontType(" + fontType + "), text(" + text + ")";

    cout<<stringText<<"\n";
    cout.flush();
}

//----------------------------------------------------------------------------------------

int getJPanelWidth()    //Panel width
{
    int width = 0;

    cout<<"W"<<"\n";

    string line;

    cin>>line;

    width = stoi(line);

    return width;
    
}

int getJPanelHeight()   //Panel height
{
    int height = 0;

    cout<<"H"<<"\n";

    string line;

    cin>>line;

    height = stoi(line);

    return height;
}
#endif
