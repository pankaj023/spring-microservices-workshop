import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HaspmapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map <Integer,String> m = new HashMap<>();
		m.put(1,"A");
		m.put(5,"Z");
		m.put(4,"B");
		m.put(2,"H");
		System.out.println(m);
		for(Map.Entry<Integer, String> temp: m.entrySet()) {
			System.out.println(temp.getKey());
		}
		List<Map.Entry<Integer, String> > list = 
	               new ArrayList<Map.Entry<Integer, String> >(m.entrySet()); 
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, String> >() { 
            public int compare(Map.Entry<Integer, String> o1,  
                               Map.Entry<Integer, String> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
		
		HashMap<Integer, String> temp = new LinkedHashMap<Integer, String>(); 
        for (Map.Entry<Integer, String> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        System.out.println(temp);
	}

}
 