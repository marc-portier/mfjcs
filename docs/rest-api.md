
# Get the current version of an item

## Request

```http
GET /items/{uuid}
```

## Response

```json
{
  "id": "{uuid}",
  "version": {version},
  "fields": {
	...
  }
}
```

## Alternative responses

### Item does not exist

404 Not Found

```json
{
	"errorcode": "error.item.does.not.exist"
}
```

# Create a new draft version

TODO: document preconditions (does item need to exist?)

```http
POST /items/{uuid}/draft

```

...
