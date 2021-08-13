# VoidSafe

Plugin TP người chơi trở về một vị trí nào đó nếu người chơi nhảy xuống void.

## Cái này khác gì cả tá plugin VoidTP trên mạng?

- 1.13+ ?
- Vẫn được update và fix bug.
- Có thể chỉnh rơi từng world khác nhau sẽ di chuyển đến các địa điểm khác nhau.
- Cho phép TP khác world.
- Config được nhiều world khác nhau.
- Chỉ TP nếu người chơi có perm (no p2w pls).
- Không TP nếu có perm bypass.

## Muốn tự build?

1. Clone đống repo này.
2. Tải maven, `cd` tới thư mục repo, `maven package`.
3. Vào thư mục `\target` lấy file `.jar`, quá ez.

## Configuration

```yaml
config-version: 1

worlds: # Có thể add bao nhiêu world tuỳ thích.
  spawn2: # Tên world
    y-trigger: 5 # Required. Nếu người chơi có y <= cái này thì sẽ trigger event
    permission: 'void.spawn' # Optional. Perm dùng để TP.
    destination: 'spawn2,0.5,114,0.5,0.0,90.0' # Required. Công thức destination: 'tên world,x,y,z,pitch,yaw'
```

## Commands

|Lệnh|Permission để dùng|Miêu tả|
|---|---|---|
|`/vsafe reload`|`voidsafe.admin`|Reload config.|

## Permission

|Permission|Miêu tả|
|---|---|
|`voidsafe.admin`|Để dùng lệnh `/vsafe reload`.|
|`voidsafe.bypass`|Không thực hiện bất cứ trigger nào cả.|
|`voidsafe.activeall`|Thực hiện toàn bộ trigger mà không cần kiểm tra permission.|