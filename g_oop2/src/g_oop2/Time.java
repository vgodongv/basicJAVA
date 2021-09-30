package g_oop2;

public class Time {
	//Ŭ������������ ����ϰ� private ������ �ð� �����Ϸ��� �޼�����.
		private int hour;
		private int minute;
		private int second;
		
		public int getHour() {//�����ǰ��� �б����� �޼���
			return hour;
		}

		public void setHour(int hour) {//������ ���� �����ϴ� �޼���. 00,01,02,03...24

			if(hour<0){
				this.hour = 0; 
			}else if(hour>23){
				this.hour=0;
				// this.hour=hour%24;
			}else{
				this.hour = hour; 
			   }
			}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			if(minute<0){
				this.minute = minute; 
			}else if(minute>59){
				this.minute=0;
				setHour(hour+1);
			}else{
				this.minute = minute; 
			   }
			}

		public int getSecond() {
			return second;
		}

		public void setSecond(int second) {
			if(second<0){
			this.second = 0;
		}else if(second>59){
			this.second=0;
			setMinute(minute+1);
			//this.second = second %60; �����ʸ� 60���� ������ ����������
			//setMinute(this.minute + (second /60)); ����п��� �Ķ���͸� 60���� ������=1
		}else{
			this.second = second; 
		   }
		}
		
		void clock(){
			while(true){
				System.out.println(toString());
				stop(); //�ѹ� ������ָ� �ð��� 1�ʵ��� ���ߴ� �޼���
				setSecond(second+1); // 1�ʸ������� �ʿ� +1�� ������ϴµ� ������ �����ϴ°��� �ƴ϶� ���� �޼��忡 �Ķ���ͷ�.
			}
		}
		
		private void stop(){// clock���� ����Ϸ��� �μ������� ���� �޼��� => ���� �Ⱥ����ְ� ���ܳ��°� ���� +private����������
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ���α׷��� ��õ��� ���߰� �ϴ� �޼���. �Ķ���ͷ� �Ѱ��ִ� ���� ���ߴ� �ð�. 
		}
		
		
		@Override //�������̵��� �޼���:��ӹ����޼����� ����������. �ƹ��͵� ��ӹ��������� object Ŭ������ ��ӹ޴°���.
		public String toString() { 
			return hour +":"+ minute+":"+second; 
		}
		
		
	}
