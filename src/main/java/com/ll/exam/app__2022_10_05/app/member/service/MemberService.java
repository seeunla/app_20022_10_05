package com.ll.exam.app__2022_10_05.app.member.service;

import com.ll.exam.app__2022_10_05.app.member.entity.Member;
import com.ll.exam.app__2022_10_05.app.member.repository.MemeberRepository;
import com.ll.exam.app__2022_10_05.app.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemeberRepository memeberRepository;
    private final JwtProvider jwtProvider;

    public Member join(String username, String password, String email) {
        Member member= Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();

        memeberRepository.save(member);

        return member;
    }

    public Optional<Member> findByUsername(String username) {
        return memeberRepository.findByUsername(username);
    }

    public String genAccessToken(Member member) {
        return jwtProvider.generateAccessToken(member.getAccessTokenClaims(), 60 * 60 *24 * 90);
    }
}
