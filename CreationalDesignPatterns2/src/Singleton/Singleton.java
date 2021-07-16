package Singleton;

public class Singleton {
	// genelde program�n ortak kulland��� ya da di�er s�n�flar taraf�ndan ortak kullan�lan, �rne�in konfig�rasyon s�n�f�, veri taban� s�n�f� i�in bu tarz kaynaklar� kulland�ran-payla�t�ran sistemlerde kullan�l�r
	//anti-pattern, solid'e ayk�r� d��er.
	//access noktas� yarat�r.
	
	//read-only bir i�lem varsa kullan�m� mant�kl� olabilir. config gibi ya da veri taban� ba�lant�s�n� sa�layan s�n�flarda kullan�labilir. 
	
	//--------problemleri ise;
	//genelde anti-pattern olarak g�sterilir ve kullan�m� ��phelidir. �ok gerekli de�ilse kullan�lmaz.
	//dependency'ler gizlenebilir.
	
	private static Singleton INSTANCE;
	private String info = "initial value";
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		
		return INSTANCE;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	

public static void main(String[] args) {
	Singleton singleton1 = Singleton.getInstance();
	System.out.println(singleton1.getInfo());
	
	Singleton singleton2 = Singleton.getInstance();
	singleton2.setInfo("Changed value");
	
	System.out.println(singleton2.getInfo());
	System.out.println(singleton1.getInfo());
	}

}
