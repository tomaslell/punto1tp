package trabajo1;

import java.io.*;
import java.io.BufferedReader;
import java.util.HashMap;

public class arar
{
public static void main(String yop)

{

	BufferedReader buff;
	System.out.println(yop);

	try
	{

		buff = new BufferedReader(new FileReader(new File(yop)));

		HashMap<String, Integer> lugar = new HashMap<String,Integer>();

		String letras ="";
		int primeras10[] = {0,0,0,0,0,0,0,0,0,0};
		String las10[] = new String[10];


		while(buff.ready())
		{
			int dentro = buff.read();


			if(dentro >= (int)'A' && dentro <= (int)'Z')
			{
				dentro -= (int)'A' - (int)'a';
			}


			if(EsLetra(dentro))
			{
				letras += (char)dentro;
			}
			else if(!letras.isEmpty())
			{
				int s = 1;
				if(lugar.containsKey(letras))
				{ 
					s += lugar.get(letras);
				}
				lugar.put(letras, s);
				letras = "";
			}

		}

		// se sierra el while

		lugar.forEach((K,s) -> mover(primeras10,s,las10,K));
		for(int i = 0;i<10;i++)
		{
			System.out.println("Puesto "+(i+1)+" : "+las10[i]+" que aparecio "+primeras10[i]+" veces" );
		}
		buff.close();
	}
	// cerramos try

	catch(Exception f){
		f.printStackTrace();
		return;
	}

}
static boolean EsLetra(int num)
{
	if(num >= (int)'a' && num<=(int)'z')
		return true;
	return false;
}
static void mover(int mejores10[], int i, String letras10[], String b)
{
	int a = 0;
	while(a<10)
	{
		if(i>mejores10[a])
		{
			for(int j = 9;j>a;j--)
			{
				mejores10[j] = mejores10[j-1];
				letras10[j] = letras10[j-1];
			}
			mejores10[a] = i;
			letras10[a] = b;
			return;
		}
		a++;
	}
	return;
}	
}