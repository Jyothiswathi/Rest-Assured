import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsStringArraywithFlatMap {

	public static void main(String[] args) {
String data[][]=new String[][] {
	{"a","b"},{"c","d"}};
	
	Stream<String[]> dataStream = Arrays.stream(data);
	
	//apply flat map
	
	Stream<String> streamToMap = dataStream.flatMap(x->Arrays.stream(x));
	
Stream<String> dataStreamFilter = streamToMap.filter(x->"a".equals(x.toString()));
dataStreamFilter.forEach(System.out::println);

Stream<String[]> DataStream2 = Arrays.stream(data);
Stream<String> streamToMap2 = DataStream2.flatMap(x->Arrays.stream(x));
Stream<String> dataStreamFilter2 = streamToMap2.filter(x->"b".equalsIgnoreCase(x.toString()));
dataStreamFilter2.forEach(System.out::println);
	}

}
