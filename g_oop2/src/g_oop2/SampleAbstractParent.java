package g_oop2;

public  abstract class SampleAbstractParent { //�߻� �޼��� ������� abstract �����ּ���
    // �߻�Ŭ����: �߻� �޼��带 �ϳ��� �������ִ°�. �� ������ ���� �޼��带 ������ �־ ��ü���� �Ұ���.
    // ������ �θ� Ŭ�����θ� ��밡��.


void method(){ //�Ϲ����� �޼���
System.out.println("����");
}

//�߻� �޼���: ����θ� �ְ� �����ΰ� ���� �޼���. ������ ���� �޼���
abstract void abstractMethod();
}

class SampleAbstractChild extends SampleAbstractParent{

@Override
void abstractMethod() { //�����Ͽ���: �߻�޼��带 ��ӹ������ �������̵��ؼ� ������ ����������. �ڽ�Ŭ������ �߻�Ŭ������ �ɰ��� �ƴϱ⶧���� 
//�ڽ�Ŭ�����鰣�� �Ȱ��� �޼ҵ尡 ������ �� ������ ���ݾ� �ٸ��� �߻�޼��� ���
System.out.println("����");
}


}