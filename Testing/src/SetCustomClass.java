import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetCustomClass {
	private String name;
	private String id;
	SetCustomClass(String name, String id){
		this.name = name;
		this.id=id;
		
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SetCustomClass other = (SetCustomClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




	public static void main(String[] args) {
		
		SetCustomClass a = new SetCustomClass("pankaj","1");
		SetCustomClass b = new SetCustomClass("pankaj","1");
		
		Set s = new HashSet();
		s.add(a);
		s.add(b);
		System.out.println(s);
		Map map1 = new HashMap();
		Map map2 = new HashMap();
		map1.equals(map2); 	//check key and values as equals
		map1.keySet().equals(map2.keySet());		//Check only key sets
		new ArrayList<>(map1.values()).equals(new ArrayList<>(map2.values()));	 //Check only values
		new HashSet<>(map1.values()).equals(new HashSet<>(map2.values()));	//allowed duplicates here
		
		
	}

}
