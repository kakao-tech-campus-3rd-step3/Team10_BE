package com.igemoney.igemoney_BE.ranking.service;

import com.igemoney.igemoney_BE.user.dto.RankingResponseDto;
import com.igemoney.igemoney_BE.user.dto.UserRankingDto;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import com.igemoney.igemoney_BE.user.service.UserRankingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UserRankingServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRankingService userRankingService;

    private User currentUser;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
        currentUser = new User("current", 1L);
        currentUser.updateRatingPoint(80);
        currentUser.increaseConsecutiveAttendance();
        currentUser.increaseConsecutiveAttendance();
        userRepository.save(currentUser);

        User testUser2 = new User("test2", 2L);
        testUser2.updateRatingPoint(50);
        testUser2.increaseConsecutiveAttendance();
        testUser2.increaseConsecutiveAttendance();
        testUser2.increaseConsecutiveAttendance();
        userRepository.save(testUser2);
    }

    @Test
    public void testUserRatingPointRanking() {

        User testUser3 = new User("test3", 3L);
        testUser3.updateRatingPoint(120);
        userRepository.save(testUser3);

        User testUser4 = new User("test4", 4L);
        testUser4.updateRatingPoint(100);
        userRepository.save(testUser4);

        User testUser5 = new User("test5", 5L);
        testUser5.updateRatingPoint(70);
        userRepository.save(testUser5);

        RankingResponseDto response = userRankingService.getRatingPointRanking(currentUser.getUserId());

        assertNotNull(response);

        // 현재 유저 항목
        assertEquals("current", response.currentUser().nickname());
        assertEquals(80, response.currentUser().point());
        assertEquals(3L, response.currentUser().rank());

        // 상위 랭커 3명
        List<UserRankingDto> top3 = response.topRankingUsers();
        assertEquals(3, top3.size());
        assertEquals("test3", top3.get(0).nickname());
        assertEquals("test4", top3.get(1).nickname());
        assertEquals("current", top3.get(2).nickname());

        // 위쪽 유저
        assertEquals(2, response.aboveUsers().size());
        assertEquals("test3", response.aboveUsers().get(0).nickname());
        assertEquals(120, response.aboveUsers().get(0).point());
        assertEquals(1L, response.aboveUsers().get(0).rank());

        assertEquals("test4", response.aboveUsers().get(1).nickname());
        assertEquals(100, response.aboveUsers().get(1).point());
        assertEquals(2L, response.aboveUsers().get(1).rank());

        // 아래쪽 유저
        assertEquals(2, response.belowUsers().size());
        assertEquals("test5", response.belowUsers().get(0).nickname());
        assertEquals(70, response.belowUsers().get(0).point());
        assertEquals(4L, response.belowUsers().get(0).rank());

        assertEquals("test2", response.belowUsers().get(1).nickname());
        assertEquals(50, response.belowUsers().get(1).point());
        assertEquals(5L, response.belowUsers().get(1).rank());
    }

    @Test
    public void testUserConsecutiveAttendanceRanking() {
        RankingResponseDto response = userRankingService.getConsecutiveAttendanceRanking(currentUser.getUserId());

        assertNotNull(response);

        // 현재 유저 항목
        assertEquals("current", response.currentUser().nickname());
        assertEquals(2, response.currentUser().point());
        assertEquals(2L, response.currentUser().rank());

        // 상위 랭커 3명
        List<UserRankingDto> top3 = response.topRankingUsers();
        assertEquals(2, top3.size());
        assertEquals("test2", top3.get(0).nickname());
        assertEquals("current", top3.get(1).nickname());

        // 위쪽 유저
        assertEquals(1, response.aboveUsers().size());
        assertEquals("test2", response.aboveUsers().get(0).nickname());
        assertEquals(3, response.aboveUsers().get(0).point());
        assertEquals(1L, response.aboveUsers().get(0).rank());

        // 아래쪽 유저
        assertEquals(0, response.belowUsers().size());
    }
}
