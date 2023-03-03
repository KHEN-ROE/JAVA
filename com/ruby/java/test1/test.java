
public class test {

	public static void main(String[] args) {
		int answer = 0;
        int n = 10;
        int n1=0;
        
        int i=0;
        while(i<10) {
        	if(n%i==0) {
        		n1=n;
        		answer = answer + n1 ;
        		break;
        	}
        }
        
        System.out.println(answer);
	}

}
