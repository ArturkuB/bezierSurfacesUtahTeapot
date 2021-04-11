package pakiet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try 
		{
			Obiekt teacup = new Obiekt("teacup.txt", "teacupresult.txt");
			Obiekt teapot = new Obiekt("teapot.txt", "teapotresult.txt");
			Obiekt teaspoon = new Obiekt("teaspoon.txt", "teaspoonresult.txt");
			teacup.czytajWspolrzedne();
			teapot.czytajWspolrzedne();
			teaspoon.czytajWspolrzedne();
			teacup.obliczPlaty();
			teapot.obliczPlaty();
			teaspoon.obliczPlaty();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}