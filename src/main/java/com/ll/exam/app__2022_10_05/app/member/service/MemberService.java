package com.ll.exam.app__2022_10_05.app.member.service;

import com.ll.exam.app__2022_10_05.app.member.entity.Member;
import com.ll.exam.app__2022_10_05.app.member.repository.MemeberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemeberRepository memeberRepository;
    public Member join(String username, String password, String email) {
        Member member= Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();

        memeberRepository.save(member);

        return member;
    }
}
