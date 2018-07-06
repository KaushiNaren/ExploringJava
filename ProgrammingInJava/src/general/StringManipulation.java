package general;

public class StringManipulation
{
	public static void main(String... args)
	{
		String str1 = "naren1";
		String str2 = "naren1";
		
		String str3 = new String("naren1");
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str3);
	}

}
