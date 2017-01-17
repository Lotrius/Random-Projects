/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Solomon
 *
 * Created on January 6, 2017, 11:20 AM
 */

#include <cstdlib>
#include <vector>
#include <string>
#include<fstream>
#include <iostream>

using namespace std;

int addNumbers(int firstNum, int secondNum = 0) {
    int combinedValue = firstNum + secondNum;
    
    return combinedValue;
}

int addNumbers(int firstNum, int secondNum, int thirdNum) {
    int combinedValue = firstNum + secondNum + thirdNum;
    
    return combinedValue;
}

class Animal {
private:
    int height;
    int weight;
    string name;
    
    static int numOfAnimals;
    
public:
    int getHeight() { return height; }
    int getWeight() { return weight; }
    string getName() { return name;}
    void setHeight(int cm) { height = cm; }
    void setWeight(int kg) { weight = kg; }
    void setName(string nm) {name = nm; }
    
    
};

/*
 * 
 */
int main(int argc, char** argv) {

    cout << "Hello world" << endl;
    const double PI = 3.14159265358;
    char ayy = 'a';
    bool yes = true;
    float f = 3.2342;
    double lmao = 1354.54879652;
    cout << "Favorite number: " << lmao << endl;
    cout << "Size of float: " << sizeof(f) << endl;
    
    int same[4];
    same[0] = 3;
    cout << same[0] << endl;
    
    string birthday = "Hi";
    
    cout << birthday << " world" << endl;
    cout << birthday + " world" << endl;
    
    char csix = '6';
    int six = 6;
    
    cout << csix + six << endl;
    cout << six + csix << endl;
    cout << csix << six << endl;
    
    cout << addNumbers(7) << endl;
    cout << addNumbers(1, 2, 3) << endl;
    
    int two = 1 << 1;
    cout << two << endl;
    
    return 0;
}

