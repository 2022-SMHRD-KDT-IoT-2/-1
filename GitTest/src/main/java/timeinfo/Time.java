package timeinfo;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Time {

	public int time_return(){ // �ϴ� �ϰ� 1 , �̿� 0 ���� �󺧸�
		Date date_now = new Date(System.currentTimeMillis()); // ����ð��� ������ Date������ �����Ѵ�
		SimpleDateFormat fourteen_format = new SimpleDateFormat("HHmm");  // ����
		int time =  Integer.parseInt(fourteen_format.format(date_now));
		System.out.println(time); // �ð�, �и� ��������.
		
		if(time >= 0600 && time <= 1800) {
			System.out.println("�ϰ��ð�");
			return 1;
		}
		else {
			System.out.println("�ϰ� �̿� �ð�");
			return 0;
		}
	}
}
