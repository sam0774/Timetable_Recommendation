package project.timetable_recommend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Model.MBTIData;
import Model.MbtiType;

public class MBTIActivity extends AppCompatActivity {
    /**
     * @param bottomNavigationView : 바텀 네비게이션 바의 다음 화면을 전환하기 위해 필요한 변수
     * @param layoutManager        : 리싸이클러 뷰를 호출하기 위해 필요한 변수
     * @param adapter              : 이 변수를 통해 목록 데이터 저장, 실행
     * @param recyclerView         : 리싸이클러 뷰를 호출하기 위해 필요한 변수
     * @param mbtiData             : 성격 유형별 특징이 저장되어있는 변수
     */
    BottomNavigationView       bottomNavigationView;
    RecyclerView.LayoutManager layoutManager;
    MBTIAdapter                adapter;
    RecyclerView               recycleView;
    MBTIData                   mbtiData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiactivity);

        /**
         * 변수들 초기화
         */
        recycleView   = (RecyclerView)findViewById(R.id.mbti_recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter       = new MBTIAdapter();
        mbtiData      = new MBTIData();
        //adapter에 데이터 넣기.
        inputDataToAdapter();
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);

        /**
         * bottomNavigationView함수는 bottom_navigation_menu.xml에서 정의한 메뉴 네비게이션을 통해 정의한 네비게이션 바의 객체입니다.
         * 이 객체에 이벤트 헨들러를 통해 어떤 네비게이션 바의 아이콘이 클릭 됬는지 찾는 메서드 입니다.
         */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab_timetable:
                        Toast.makeText(getApplicationContext(),"시간표에서 startresultfor...호출했으니까 이걸 반환해줘야함", Toast.LENGTH_LONG).show();
                        System.out.println("시간표에서 startresultfor...호출했으니까 이걸 반환해줘야함");
                        return true;
                    case R.id.tab_MBTI:

                        Toast.makeText(getApplicationContext(),"현재화면 누르는중", Toast.LENGTH_LONG).show();
                        System.out.println("현재화면 누르는중");

                        return true;
                    case R.id.tab_setting:
                        Toast.makeText(getApplicationContext(),"여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고)");
                        return true;
                }
                return false;
            }
        });

    }

    /**
     * 주어진 데이터를 adapter에 추가하는 func
     * 추후 recyclerView를 통해 이 데이터가 보여짐.
     */
    public void inputDataToAdapter(){
        for (int i = 0; i < this.mbtiData.getMbti_type().length; i++){
            this.adapter.addItem(this.mbtiData.getMbti_type()[i]);
        }
    }
}


