package g_oop2;

public class Time {
	//클래스내에서만 사용하게 private 붙혀서 시간 셋팅하려면 메서드사용.
		private int hour;
		private int minute;
		private int second;
		
		public int getHour() {//변수의값을 읽기위한 메서드
			return hour;
		}

		public void setHour(int hour) {//변수에 값을 저장하는 메서드. 00,01,02,03...24

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
			//this.second = second %60; 현재초를 60으로 나눠서 나머지저장
			//setMinute(this.minute + (second /60)); 현재분에다 파라미터를 60으로 나눈값=1
		}else{
			this.second = second; 
		   }
		}
		
		void clock(){
			while(true){
				System.out.println(toString());
				stop(); //한번 출력해주면 시간이 1초동안 멈추는 메서드
				setSecond(second+1); // 1초멈췄으니 초에 +1초 해줘야하는데 변수에 직접하는것이 아니라 만든 메서드에 파라미터로.
			}
		}
		
		private void stop(){// clock에서 사용하려고 부수적으로 만든 메서드 => 굳이 안보여주고 숨겨놓는게 나음 +private접근제어자
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 프로그램을 잠시동안 멈추게 하는 메서드. 파라미터로 넘겨주는 값이 멈추는 시간. 
		}
		
		
		@Override //오버라이딩된 메서드:상속받은메서드의 내용을변경. 아무것도 상속받지않으면 object 클래스를 상속받는것임.
		public String toString() { 
			return hour +":"+ minute+":"+second; 
		}
		
		
	}
