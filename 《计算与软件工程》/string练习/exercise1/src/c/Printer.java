package c;

public interface Printer {

//	将输入的字符串进行调整并输出，调整规则为：
//	输入“abcde”，输出“edcba”；输入“1234”，输出“4321”。
	void print1(String s);
	
//	将输入的字符串进行调整并输出，调整规则为：
//	输入“abcde”，输出    c
//									  bcd
//									 abcde 
//	输入“1234”，输出    23
//									1234
//	即输出形状为金字塔形
	void print2(String s);
	
//	输入一个由字母组成的字符串，如“vxKjhAeSXdfa”，按照字母顺序，打印出
//	最前面的字母和最后面的字母，以上面的字符串为例，打印出“a x”，
//	程序对字母大小写不敏感
	void print3(String s);
	
//	输入一个名字，改变形式输出这个名字。
//	例如输入为“First Middle Last”，输出为“Last, First M.”
//	M为middle name的第一个字母
	void print4(String s);
}
