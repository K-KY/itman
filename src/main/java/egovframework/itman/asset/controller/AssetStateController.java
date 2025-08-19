package egovframework.itman.asset.controller;

import egovframework.itman.asset.dto.AssetStateDto;
import egovframework.itman.asset.model.entity.AssetFactory;
import egovframework.itman.asset.model.service.interfaces.AssetStateService;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("assets/states")
public class AssetStateController {

    private final AssetStateService assetStateService;

    @GetMapping
    public Page<AssetStateDto.Response> read(int page, int size, Long groupSeq, SortDto sort) {
        Pageable pageable = PageRequest.of(page - 1, size, sort.getSorts());
        return assetStateService.read(pageable, groupSeq, sort).map(AssetFactory::toDto);
    }
    @PostMapping
    public AssetStateDto.Response create(@RequestBody AssetStateDto.Request assetStateDto) {
        return AssetFactory.toDto(assetStateService.create(assetStateDto));
    }
    @PatchMapping
    public AssetStateDto.Response update(@RequestBody AssetStateDto.Request request) {
        return AssetFactory.toDto(assetStateService.update(request));
    }
}
