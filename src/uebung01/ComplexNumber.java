/**
 * 
 */
package uebung01;

/**
 * @author Duc
 *
 */
public class ComplexNumber  {
	
private int img;
private int real;
	
public ComplexNumber(int img, int real){
	this.img = img;
	this.real= real;
}

public ComplexNumber(ComplexNumber other){
	this.img = other.img;
	this.real = other.real;
}


public String toString() {
	return this.img + "+ i* " + this.real;
}


public void add(ComplexNumber other) {
	this.img = this.img + other.img;
	this.real = this.real + other.img;
}


public void sub(ComplexNumber other) {
	this.img = this.img - other.img;
	this.real = this.real - other.img;
}


public void mul(ComplexNumber other) {
	this.img = (this.img * other.img - this.real * other.real);
	this.real = (this.img * other.real + this.real * other.img);
}


public void div(ComplexNumber other) {
	this.img = (this.img * other.img + this.real * other.real)/(other.img*other.img + other.real*other.real);
	this.real = (this.real * other.img + this.img * other.real)/(other.img*other.img + other.real*other.real);
}

public void conjugation() {
	this.real = -this.real;
}

public double absoluteValue(){
	return Math.sqrt(this.img*this.img + this.real*this.real);
}

public int getImg() {
	return img;
}

public void setImg(int img) {
	this.img = img;
}

public int getReal() {
	return real;
}

public void setReal(int real) {
	this.real = real;
}
	
}
