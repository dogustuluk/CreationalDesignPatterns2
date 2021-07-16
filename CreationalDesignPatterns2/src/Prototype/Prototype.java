package Prototype;

public class Prototype implements Cloneable {
	
	//yaratýlmasý çok maliyetli nesneleri devamlý yaratmak istememizden dolayý kullanýlýr.
	//bir sýnýfýn yeni instance'larýný yaratmak istiyoruz ama yaratýlýrken çok fazla iþlem ve maliyet yaratýr, bunu önlemek için kullanýrýz.
	//burda yarattýðýn bir nesnenin kopyasýný alýyorsun ve diðer adýmda tekrardan instance yaratmana gerek kalmýyor.
	//örneðin test data'sý oluþturduðunda kullanýrsýn.
	
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

	
	//dýþarýdan da eriþilmesi için override edilmiþtir.
	@Override
	protected Prototype clone() {
		Prototype cpy = this;
		return cpy; // bu iki kod satýrý ile ise shallow clone yapýlmýþtýr. yani burada referans alarak kopya oluþuyor. yeni nesne klonlandýktan sonra ilk nesnenin de deðerleri deðiþiyor, son alýnan klon ile 
		// ayný deðerlere sahip olmaktadýr.
		
		//return new Prototype(field1, field2); //new diyerek deep clone yapýlmýþtýr yani deðiþtirilen nesne referans almamýþtýr bu sayede ilk nesne klon aldýktan sonra deðiþmez
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
