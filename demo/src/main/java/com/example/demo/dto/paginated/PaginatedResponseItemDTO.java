package com.example.demo.dto.paginated;

import com.example.demo.dto.IteamDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseItemDTO {
    private List<IteamDTO> list;
    private  long dataCount;
}
