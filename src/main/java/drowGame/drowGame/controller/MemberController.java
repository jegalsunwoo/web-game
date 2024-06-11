package drowGame.drowGame.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import drowGame.drowGame.dto.MemberDTO;
import drowGame.drowGame.dto.ResultDTO;
import drowGame.drowGame.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/loginProc")
    @ResponseBody
    public ResponseEntity<ResultDTO> loginProc(@RequestBody MemberDTO memberDTO, HttpSession httpSession){
        ResultDTO resultDTO = memberService.loginProc(memberDTO, httpSession);
        return ResponseEntity.ok(resultDTO);
    }
    @GetMapping("/join")
    public String goJoinForm(){
        return "joinForm";
    }

    @PostMapping("/joinProc")
    @ResponseBody
    public ResponseEntity<ResultDTO> joinProc(@RequestBody MemberDTO memberDTO) {
        ResultDTO resultDTO = memberService.joinProc(memberDTO);
        return ResponseEntity.ok(resultDTO);
    }

    @GetMapping("/logout")
    public String logoutProc(HttpSession httpSession){
        memberService.logoutProc(httpSession);
        return "loginForm";
    }

    @PostMapping("/duplicateCheck")
    @ResponseBody
    public ResponseEntity<ResultDTO> duplicateCheck(@RequestBody String data) throws JsonProcessingException {
        ResultDTO resultDTO = memberService.duplicateCheck(data);
        return ResponseEntity.ok(resultDTO);
    }

}
