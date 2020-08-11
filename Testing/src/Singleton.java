class Singleton{  
	private static Singleton obj;  
	private Singleton(){}  

	public static Singleton getA(){  
		if (obj == null){  
			synchronized(Singleton.class){  
				if (obj == null){  
					obj = new Singleton();//instance will be created at request time  
				}  
			}              
		}  
		return obj;  
	}  
}