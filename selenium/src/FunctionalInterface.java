import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionalInterface {

	public static void main(String[] args) {
		Function<String,Integer> function=(x)->x.length();
int len		=function.apply("this is jyothi");
System.out.println(len);


Function<Integer,Integer> function2=(x)->x*2;
Integer mul = function2.apply(2);
System.out.println(mul);
Integer multi = function.andThen(function2).apply("this");
System.out.println(multi);


BinaryOperator<Integer> func=(x,y)->x+y;
Integer add = func.apply(1, 2);
System.out.println(add);

//byFunction interface
BiFunction<Integer,Integer,Integer> bi=(x,y)->x+y;
Integer addition = bi.apply(2, 3);
System.out.println(addition);


//unaryOperator
UnaryOperator<Integer>  u=x->x*2;
Integer a=u.apply(2);
System.out.println(a);

List<String> l=new ArrayList<String>();
l.add("joy");
l.add("Swathi");
  l.replaceAll(e->e+"susi");
  System.out.println(l);
  
  l.stream().forEach(k->System.out.println(k+1));
 List<String> data = l.stream().filter(x->x.startsWith("j")).collect(Collectors.toList());
 System.out.println(data);
 
 
 l.stream().forEach(System.out::println);
  
  



	}

}
