package org.zerock.tp4.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.tp4.board.domain.Board;
import org.zerock.tp4.board.domain.Criteria;
import org.zerock.tp4.board.dto.BoardDTO;
import org.zerock.tp4.board.dto.PageDTO;
import org.zerock.tp4.board.service.BoardService;
import org.zerock.tp4.board.service.TimeService;

@Controller
@RequestMapping("/board/*")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final TimeService timeService;

    private final BoardService boardService;

    @GetMapping("/time")
    public void GetTime(int num,Model model){
        log.info("================controller getTime==============");
        log.info(num % 0);
        model.addAttribute("time", timeService.getNow());
    }

    @GetMapping("/register")
    public void registerGet(){

    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        log.info("boardDTOM     " + boardDTO);

        Long bno = boardService.register(boardDTO);

        log.info("==========================c registerPost======================");
        log.info(bno);
        redirectAttributes.addFlashAttribute("result", bno);

        return "redirect:/board/list";
    }

//    @GetMapping("/list")
//    public void getList(Model model){//jsp로 담아서 보내야하니깐 model
//
//        log.info("c  getList..................");
//        model.addAttribute("dtoList", boardService.getDTOList());
//    }

    @GetMapping("/list")
    public void list(Criteria cri,Model model){
        log.info("list:" +cri);
        model.addAttribute("list", boardService.getDTOList(cri));
        model.addAttribute("pageMaker", new PageDTO(cri, 123));
    }

    @GetMapping(value = {"/read","/modify"})
    public void read(Long bno, Model model){
        log.info("c    read" + bno);
        model.addAttribute("boardDTO", boardService.read(bno));
    }

    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes redirectAttributes){
        log.info("c         remove: " + bno);

        if (boardService.remove(bno)){
            log.info("remove success");
            redirectAttributes.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        log.info("c                modify :" + boardDTO);
        if(boardService.modify(boardDTO)){
            redirectAttributes.addFlashAttribute("result", "modified");
        }
        redirectAttributes.addAttribute("bno", boardDTO.getBno());
        return "redirect:/board/read";
    }

}
