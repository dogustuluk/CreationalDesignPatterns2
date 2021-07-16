package Prototype;

public class Prototype implements Cloneable {
	
	//yarat�lmas� �ok maliyetli nesneleri devaml� yaratmak istememizden dolay� kullan�l�r.
	//bir s�n�f�n yeni instance'lar�n� yaratmak istiyoruz ama yarat�l�rken �ok fazla i�lem ve maliyet yarat�r, bunu �nlemek i�in kullan�r�z.
	//burda yaratt���n bir nesnenin kopyas�n� al�yorsun ve di�er ad�mda tekrardan instance yaratmana gerek kalm�yor.
	//�rne�in test data's� olu�turdu�unda kullan�rs�n.
	
	private String field1;
	private String field2;
	
	
	public Prototype(String field1, String field2) {
		super();
		this.field1 = field1;
		this.field2 = field2;
	}




	public String getField1() {
		return field1;
	}




	public void setField1(String field1) {
		this.field1 = field1;
	}




	public String getField2() {
		return field2;
	}




	public void setField2(String field2) {
		this.field2 = field2;
	}

	
	//d��ar�dan da eri�ilmesi i�in override edilmi�tir.
	@Override
	protected Prototype clone() {
		Prototype cpy = this;
		return cpy; // bu iki kod sat�r� ile ise shallow clone yap�lm��t�r. yani burada referans alarak kopya olu�uyor. yeni nesne klonland�ktan sonra ilk nesnenin de de�erleri de�i�iyor, son al�nan klon ile 
		// ayn� de�erlere sahip olmaktad�r.
		
		//return new Prototype(field1, field2); //new diyerek deep clone yap�lm��t�r yani de�i�tirilen nesne referans almam��t�r bu sayede ilk nesne klon ald�ktan sonra de�i�mez
	}


	public static void main(String[] args) {
		
		Prototype prototype1 = new Prototype("original value 1", "original value 2");
		System.out.println(String.format("original instance field1: %s - field2: %s", prototype1.getField1(), prototype1.getField2()));
		
		Prototype prototype2 = prototype1.clone();
		prototype2.setField1("changed value 1");
		prototype2.setField2("changed value 2");
		
		System.out.println(String.format("original instance field1: %s - field2: %s", prototype2.getField1(), prototype2.getField2()));
		System.out.println(String.format("original instance field1: %s - field2: %s", prototype1.getField1(), prototype1.getField2()));
	}

}
