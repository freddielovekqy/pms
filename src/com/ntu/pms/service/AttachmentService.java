package com.ntu.pms.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ntu.pms.dto.AttachmentDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;

public interface AttachmentService {

    AttachmentDTO uploadAttachment(int projectId, String folderName, MultipartFile file, UserDTO userDTO)
            throws IOException;

    List<AttachmentDTO> findAttachmentDTOByFolder(int projectId, String folderName);

    AttachmentDTO deleteAttachment(int projectId, int attachmentId);

    File downloadAttachment(int projectId, int attachmentId);

    AttachmentDTO getDTOById(int attachmentId) throws BussinessException;
}
