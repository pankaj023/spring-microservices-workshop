
public  class StaticClass {
	final static String abc;
	 StaticClass(){
		
		System.out.println("constructor");
	}
	{
		System.out.println("instance block");
	}
	
	static {
		abc = "10";
		System.out.println("static block");
	}
	
	public static void display() {
		System.out.println("display");
	}

	public static void main(String[] args) {
		StaticClass abc = new StaticClass();
			
	}

}


