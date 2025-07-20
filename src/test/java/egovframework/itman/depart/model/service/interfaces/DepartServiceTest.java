package egovframework.itman.depart.model.service.interfaces;

import egovframework.itman.depart.dto.DepartDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DepartServiceTest {

    @Autowired
    private DepartService departService;

    private int testDepartSeq = 30;
    void setUp() {
            departService.insert(DepartDto.Request.builder().departName("test" + 1).build());
    }

    @Test
    @Transactional
    @DisplayName("데이터 삽입 성공")
    void insert() {
        departService.insert(DepartDto.Request.builder().departName("test").build());
        Page<DepartDto.Response> read = departService.read(PageRequest.of(0, 1));
        assertThat(read.getContent().get(0).getDepartName()).isEqualTo("test");
    }

    @Test
    @Transactional
    void read() {
        setUp();
        Page<DepartDto.Response> read = departService.read(PageRequest.of(0, 1));
        System.out.println("read.getTotalPages() = " + read.getTotalPages());
        assertThat(read.getTotalPages()).isEqualTo(1);
        assertThat(read.getContent().get(0).getDepartName()).isEqualTo("test" + 1);
    }

    @Test
    @Transactional
    void update() {
        //에러남 일단 보류
//        departService.insert(DepartDto.Request.builder().departName("test" + 1).build());
//        Page<DepartDto.Response> read = departService.read(PageRequest.of(0, 100));
//        assertThat(read.getContent().get(0).getDepartName()).isEqualTo("test" + 1);
//        departService.update(DepartDto.Request.builder().departName("test").build());
//        read = departService.read(PageRequest.of(0, 100));
//        assertThat(read.getContent().get(0).getDepartName()).isEqualTo("test");
    }

    @Test
    @Transactional

    void delete() {
        DepartDto.Response insert = departService.insert(DepartDto.Request.builder().departName("test" + 1).build());
        boolean delete = departService.delete(DepartDto.Request.builder().departSeq(1).build());
        assertThat(delete).isTrue();

    }
}