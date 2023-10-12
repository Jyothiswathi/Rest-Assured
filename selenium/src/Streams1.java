import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams1 {
	
	public static void main(String args[])
	{
		List<Customer> customerList=Arrays.asList(
new Customer("jyo",26),
new Customer("swa",25),
new Customer("pave",22));


Customer	customer	=customerList.stream().filter(x->x.getName().equals("jyo")).findAny().orElse(null);
System.out.println(customer.getName()+ " "+customer.getAge());

Customer customer1 = customerList.stream().filter(x->x.getName().equalsIgnoreCase("swa") && x.getAge()==22).findAny().orElse(null);
		System.out.println(customer1);	
		
		
		//print all the names from thelist
		
		List<String> a = customerList.stream().map(Customer::getName).collect(Collectors.toList());
		a.forEach(System.out::println);
				
		
	}

}
