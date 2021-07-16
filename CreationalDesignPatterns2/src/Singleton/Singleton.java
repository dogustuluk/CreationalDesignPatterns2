package Singleton;

public class Singleton {
	// genelde programýn ortak kullandýðý ya da diðer sýnýflar tarafýndan ortak kullanýlan, örneðin konfigürasyon sýnýfý, veri tabaný sýnýfý için bu tarz kaynaklarý kullandýran-paylaþtýran sistemlerde kullanýlýr
	//anti-pattern, solid'e aykýrý düþer.
	//access noktasý yaratýr.
	
	//read-only bir iþlem varsa kullanýmý mantýklý olabilir. config gibi ya da veri tabaný baðlantýsýný saðlayan sýnýflarda kullanýlabilir. 
	
	//--------problemleri ise;
	//genelde anti-pattern olarak gösterilir ve kullanýmý þüphelidir. çok gerekli deðilse kullanýlmaz.
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
