package pakiet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Obiekt {
	private Punkt p[][][];
	private int n;
	private File obiekt;
	private FileWriter result;
	
	public Obiekt(String txt1, String txt2) throws IOException
	{
		obiekt = new File(txt1);
		result = new FileWriter(txt2);
	}
	
	void czytajWspolrzedne()
	{
		try 
		{
			Scanner s = new Scanner(obiekt);
			s.useDelimiter(" |" + "\n");	
			String a = s.next();
			a = a.replace("\n", "").replace("\r", "");
			n = Integer.parseInt(a);
			p = new Punkt[n][4][4];
			for(int k = 0; k < n; k++)
			{
				for(int i = 0; i < 4; i++)
				{
					for(int j = 0; j < 4; j++)
					{
						p[k][i][j] = new Punkt(Double.parseDouble(s.next()), Double.parseDouble(s.next()), Double.parseDouble(s.next()));
					}
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	void obliczPlaty() throws IOException
	{
		double putx = 0, puty = 0, putz = 0;
		
			result.write("x, y, z"+  System.lineSeparator());
			
			for(int k = 0; k < n; k++)
			{
				for(double w = 0.0; w <= 1.0; w = w + 0.01)
				{
					for(double v = 0.0; v <= 1.0; v = v + 0.01)
					{   
						putx = 0.0;
						puty = 0.0;
						putz = 0.0;
						for(int j = 0; j < 4; j++)
							{
								for(int i = 0; i < 4; i++)
								{
									putx += p[k][i][j].x * Bernstein(i, 3, v) * Bernstein(j, 3, w);
									puty += p[k][i][j].y * Bernstein(i, 3, v) * Bernstein(j, 3, w);
									putz += p[k][i][j].z * Bernstein(i, 3, v) * Bernstein(j, 3, w);
								}
							}
						result.write(putx + ", " + puty + ", " + putz + System.lineSeparator());
						System.out.println(k);
					}
				}
			}
	}
	
	public static int fac(int n) {
	       if (n == 0) {
	           return 1;
	       } else {
	           int result = 1;
	           for (int i = 1; i <= n; i++) {
	               result *= i;
	           }

	           return result;
	       }
	   }
	   
	   public static double Bernstein(int i, int n, double t) {
	       double factor_0 = fac(n) / (fac(n - i) * fac(i));
	       double factor_1 = Math.pow((1 - t),(n - i));
	       double factor_3 = Math.pow(t, i);
	       return  factor_0 * factor_1 * factor_3;
	   }
}


