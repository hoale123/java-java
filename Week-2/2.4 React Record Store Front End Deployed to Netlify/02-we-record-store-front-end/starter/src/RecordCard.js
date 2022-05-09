function RecordCard({ record, notify }) {

    function handleDelete() {
    }

    return (
        <tr key={record.recordId}>
            <td>{record.artist}</td>
            <td>{record.album}</td>
            <td>{record.year}</td>
            <td>
                <button id="deleteButton" className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                <button id="editButton" className="btn btn-secondary" type="button" onClick={() => notify({ action: "edit-form", record: record })}>Edit</button>
            </td>
        </tr>
    );
}

export default RecordCard;
