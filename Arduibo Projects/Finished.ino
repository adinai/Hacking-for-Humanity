#include <SoftwareSerial.h>
 
int Tx=2; //전송
int Rx=3; //수신
int mq3Pin = A0;
byte buffer[1024];
int bufferPosition;
int flag=0;
int max0;


SoftwareSerial BTSerial(Tx, Rx);
 
void setup() 
{
  BTSerial.begin(9600);
  Serial.begin(9600);
  bufferPosition=0;
}
 
void loop(){
  int val = analogRead(mq3Pin);
  delay(100);

  if(val<100){                            // 정상   0
    BTSerial.println("0");
    delay(200);
  }
  if(val>=100 && val<130){
    float sum0 = (float)val/(float)6300;
    BTSerial.println(sum0);
    delay(200);
  }
  if(val>=130 && val<340){                // 면허취소   0.03 부터 0.08
    float sum1 = (float)val/(float)4200;
    BTSerial.println(sum1);
    delay(200);
  }
  if(val>=340 && val<840){                // 면허정지   0.08 부터 0.2
    float sum2 = (float)val/(float)4200;
    BTSerial.println(sum2);
    delay(200);
  }
  if(val>840){                            // 사망     0.2 부터
    float sum3 = (float)val/(float)4200;
    BTSerial.println(sum3);
    delay(200);
}
}
