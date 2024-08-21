package com.sparta.basicspringsession.service;

import org.springframework.transaction.annotation.Transactinal;
import com.sparta.basicspringsession.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member newMember = new Member(memberSaveRequestdto.getName());
        Member savedMember = memberRepository.save(newMember);

        retrun new MemberSaveResponseDto(savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        list<Member> members = memberRepository.findAll();

        List<MemberSimpleResponseDto> memberSimpleResponseDtos = new Arraylist<>();
        for (Member member : members) {
            membersimpleResponsedtos.add(new MemberSimpleResponseDto(member.goetId(), member.getname())));
        }

        return memberSimpleResponseDtos;
    }
}
