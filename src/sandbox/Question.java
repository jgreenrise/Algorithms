package sandbox;

public class Question {
	
	class Inner{
		void test(){
			if(Test4.this.flag);{
				sample();
			}
		}
	}
	
	public void sample() {
		// TODO Auto-generated method stub
		System.out.println("sample");
	}
	
	public Test4(){
		(new Inner()).test();
	}

	public static void main(String[] args) {
		new Test4();
	}

}
