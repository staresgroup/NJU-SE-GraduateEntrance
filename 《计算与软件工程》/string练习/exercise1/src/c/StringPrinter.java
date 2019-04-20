package c;

public class StringPrinter implements Printer {

	public void print1(String s) {
		StringBuffer Temporary=new StringBuffer();
		Temporary.append(s);
		Temporary.reverse();
		System.out.println(Temporary);
	}
	public void print2(String s) {
		char StringArray[]=s.toCharArray();
		int Length=StringArray.length;
		if(Length%2==0){                        //长度为偶数
			for(int i=1;i<=Length/2;i++){
				for(int j=0;j<Length;j++){
					if((j<(Length/2+i))&&(j>=(Length/2-i))){
						System.out.print(StringArray[j]);
					}
					else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		else{                                  //长度为奇数
			for(int i=0;i<=Length/2;i++){
				for(int j=0;j<Length;j++){
					if((j<=(Length/2+i))&&(j>=(Length/2-i))){
						System.out.print(StringArray[j]);
					}
					else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			
		}
	}
	public void print3(String s) {
		char Maximum;
		char Minimum;
		int Temporary1;
		int Temporary2;
		int Temporary3;
		Temporary1=Temporary2=Temporary3=0;
		char StringArray[]=s.toCharArray();          //分割字符串为char数组
		int StringLength=StringArray.length;
		Maximum=Minimum=StringArray[0];
		for(int i=0;i<StringLength;i++){            //进行比较排序
			Temporary1=StringArray[i];
			Temporary2=Maximum;
			Temporary3=Minimum;
			if((64<Temporary1)&&(Temporary1<91)){
				Temporary1+=32;
			}
			if((64<Temporary2)&&(Temporary2<91)){
				Temporary2+=32;
			}
			if((64<Temporary3)&&(Temporary3<91)){
			    Temporary3+=32;
			}
			if(Temporary1>Temporary2){
				Maximum=StringArray[i];
			}
			if(Temporary1<Temporary3){
				Minimum=StringArray[i];
			}
		}
		System.out.println(Minimum+" "+Maximum);
	}
	public void print4(String s) {
		String[] StringAfterSplit=s.split(" ");
		int Length=StringAfterSplit.length;
		if(Length==3){
			char[] MiddleName=StringAfterSplit[1].toCharArray();
			System.out.println(StringAfterSplit[2]+","+StringAfterSplit[0]+" "+MiddleName[0]);
		}
		else{
			System.out.print("The name should be in form like “First Middle Last”");
		}
	}
	
	public static void main(String[] args) {
		StringPrinter sp = new StringPrinter();
		sp.print1("123456 sd");
		sp.print2("1234567");
		sp.print2("123456");
		sp.print3("vxKjhAeSXdfa");
		sp.print4("William Jefferson Clinton");
	}
	
}
