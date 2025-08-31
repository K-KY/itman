package egovframework.itman.asset.controller;

import egovframework.itman.asset.dto.AssetDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("assets/details")
public class AssetDetailController {

    @GetMapping("{groupSeq}")
    public AssetDto.Response assetDetail(@AuthenticationPrincipal UserDetails user,  @PathVariable Long groupSeq,
                                         @RequestParam Long seq) {
        return null;
    }
}
