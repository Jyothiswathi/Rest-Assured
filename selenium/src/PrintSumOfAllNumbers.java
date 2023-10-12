import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PrintSumOfAllNumbers {

	public static void main(String[] args) {
		int s=0;
		int count=0;

	List<Integer> sum = Arrays.asList(1,2,3,4,5);
//	Optional<Integer> s = sum.stream().reduce((a,b)->a+b);
//	System.out.println(s);
	
	//for loop
	
//for(int i=0;i<sum.size();i++)	
//{
//s+=sum.get(i)	;
//}
//System.out.println(s);
	
	
	while(sum.size()>count)
	{
		
		
		s=s+sum.get(count);
		count++;
	}
	System.out.println(s);

	}
	
	

}
